package exercise04;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile extends SwingWorker<Integer, Integer> {

    private File fileFrom;
    private File fileTo;

    public CopyFile(File fileFrom, File fileTo) {
        this.fileFrom = fileFrom;
        this.fileTo = fileTo;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileFrom));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileTo))) {

            long fileSize = fileFrom.length();
            byte[] buffer = new byte[8192];
            int bytesRead;
            long totalBytesRead = 0;

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;

                int progress = (int) ((totalBytesRead * 100) / fileSize);
                setProgress(progress);
            }

            return (int) totalBytesRead;
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để xử lý trong phương thức done()
        }
    }

    @Override
    protected void process(List<Integer> chunks) {
    }

    @Override
    protected void done() {
        try {
            if (!isCancelled()) {
                JOptionPane.showMessageDialog(null, "Hoàn thành! Tổng số byte: " + get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
