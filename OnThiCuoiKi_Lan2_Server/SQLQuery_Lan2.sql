--a) (1.5 điểm) Thêm một món ăn mới. Trong đó, mã số của món phải bắt đầu là F và theo sau ít nhất 3 ký số. 
--+ addFood (food: Food) : boolean 

--b) (1.5 điểm) Liệt kê danh sách mặt hàng là món đặt biệt của nhà hàng mà có sử dụng nguyên liệu được nhập từ nhà cung cấp nào đó khi biết tên nhà cung cấp (tìm tương đối, không phân biệt chữ thường hoa). 
--+ listItems (supplierName: String) : List<Item> 
SELECT i.id, i.description, i.name, i.on_special, i.price
FROM beverages b
JOIN items i ON b.id = i.id
WHERE i.on_special = 1 AND b.supplier_name LIKE '%Anna%'


--c) (1.5 điểm) Tính giá gốc của từng món ăn sau khi chế biết thành phẩm. Kết quả sắp xếp giảm dần theo đơn giá gốc. 
--Trong đó: Giá gốc món ăn = (số lượng nguyên liệu * đơn giá nguyên liệu) + (thời gian chuẩn bị + thời gian phục vụ) * 0.2$ 
--+ public listFoodAndCost(): Map<Food, Double> 

SELECT f.id, SUM((ing.quantity + ing.price) + (f.preparation_time + f.serving_time)) * 0.2 AS cost
FROM foods f
JOIN items_ingredients i_i ON i_i.item_id = f.id
JOIN ingredients ing ON ing.ingredient_id = i_i.ingredient_id
GROUP BY f.id
ORDER BY cost DESC


