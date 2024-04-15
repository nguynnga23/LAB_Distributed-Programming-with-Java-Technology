package dao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.types.Node;
import org.neo4j.driver.Record;

import entity.Category;
import entity.Product;
import entity.Supplier;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;
import lombok.NoArgsConstructor;
import util.AppUtil;

/**
 * @author Nguyen Thi Nga
 * @date Mar 19, 2024
 */
@NoArgsConstructor
public class ProductDao {
	// Open the driver
	private Driver driver;
	private SessionConfig sessionConfig;

	public ProductDao(Driver driver, String dbName) {
		super();
		this.driver = driver;
		sessionConfig = SessionConfig.builder().withDatabase(dbName).build();
	}

	// Close the driver
	public void close() {
		driver.close();
	}

//	Thêm/ xóa/ sửa/ tìm kiếm
	public String addNewProduct(Product p) {
		String query = "CREATE(p:Product{reorderLevel: $rdl,unitsInStock: $uIS,unitPrice: $uP,supplierID: $sId ,productID: $pID,quantityPerUnit: $qPU,discontinued: $dis,productName: $pName,unitsOnOrder: $uOO,categoryID: $cID}";
		Map<String, Object> pars = Map.of("rdl", p.getReorderLevel(), "uIS", p.getUnitsInStock(), "uP",
				p.getUnitPrice(), "sId", p.getSupplier().getSupplierId(), "pID", p.getProductId(), "qPU",
				p.getQuantityPerUnit(), "dis", p.getDiscoutinued(), "pName", p.getProductName(), "uOO",
				p.getUnitsOnOrder(), "cID", p.getCategory().getCategoryId());
		try (Session session = driver.session(sessionConfig)) {
			return session.executeWrite(tx ->{
				Result result = tx.run(query, pars);
				if (!result.hasNext())
					return null;
				Record record = result.stream().findFirst().get();
				return record.get("productID").asString();
			});
		}
	}

//	Tìm các sản phẩm được cung cấp bởi một nhà cung cấp nào đó khi biết tên nhà cung cấp
	public List<Product> getProductsBySupplierName(String supplierName) {
		String query = "MATCH(s:Supplier)-[:SUPPLIES]->(p:Product) " + "WHERE s.companyName = $companyName "
				+ "RETURN p, s.companyName AS SupplierName ";
		Map<String, Object> pars = Map.of("companyName", supplierName);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				return result.stream().map(record -> {
					Node node = record.get("p").asNode();
					return AppUtil.nodeToProduct(node);
				}).toList();
			});
		}

	}

//	Tìm danh sách sản phẩm có giá cao nhất.
	public List<Product> getProductsWithMaxUnitPrice() {
		String query = "MATCH (p:Product)\r\n" + "WITH max(p.unitPrice) AS maxPrice\r\n"
				+ "MATCH (p:Product {unitPrice: maxPrice})\r\n" + "RETURN p";
//		Map<String, Object> pars = Map.of("companyName", supplierName);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);
				return result.stream().map(record -> {
					Node node = record.get("p").asNode();
					return new Product(node.get("productID").asString(),
							Integer.parseInt(node.get("reorderLevel").toString()),
							Integer.parseInt(node.get("unitsInStock").toString()),
							Float.parseFloat(node.get("unitPrice").toString()), node.get("quantityPerUnit").asString(),
							Boolean.parseBoolean(node.get("discoutinued").toString()),
							node.get("productName").asString(), Integer.parseInt(node.get("unitsOnOrder").toString()));
				}).toList();
			});
		}
	}

//	Tính tổng số lượng của từng sản phẩm đã bán ra.
//	+ getTotalProduct(): Map<String, Integer>
	public Map<String, Integer> getTotalProduct() {
		String query = "MATCH(p:Product)<-[r:ORDERS]-()\r\n"
				+ "RETURN p.productName AS ProductName, sum(r.quantity) AS TotalQuantitySold";
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query);

				return result.stream().collect(Collectors.toMap(record -> record.get("ProductName").asString(),
						record -> record.get("TotalQuantitySold").asInt()));
			});
		}
	}

//	Dùng text search để tìm kiếm sản phẩm theo tên sản phẩm.
//	CREATE FULLTEXT INDEX productNameIndex FOR (p:Product) ON EACH [p.productName]
	public List<Product> getProductsByTextSearch(String name) {
		String query = "CALL db.index.fulltext.queryNodes('productNameIndex', $name) YIELD node, score\r\n"
				+ "RETURN node as product";
		Map<String, Object> pars = Map.of("name", name);
		try (Session session = driver.session(sessionConfig)) {
			return session.executeRead(tx -> {
				Result result = tx.run(query, pars);
				return result.stream().map(record -> {
					Node node = record.get("product").asNode();
					return new Product(node.get("productID").asString(),
							Integer.parseInt(node.get("reorderLevel").toString()),
							Integer.parseInt(node.get("unitsInStock").toString()),
							Float.parseFloat(node.get("unitPrice").toString()), node.get("quantityPerUnit").asString(),
							Boolean.parseBoolean(node.get("discoutinued").toString()),
							node.get("productName").asString(), Integer.parseInt(node.get("unitsOnOrder").toString()));
				}).toList();
			});
		}
	}

}
