import java.io.File;
import java.util.Scanner;

public class FileSizeCalculator {
    public static void main(String[] args) {
        // Nhập đường dẫn của file từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn của file: ");
        String filePath = scanner.nextLine();
        scanner.close();

        // Tạo một đối tượng File từ đường dẫn được nhập
        File file = new File(filePath);

        // Kiểm tra xem file tồn tại hay không
        if (file.exists()) {
            // Lấy độ lớn của file và chuyển đổi sang đơn vị KB hoặc MB nếu cần
            long fileSize = file.length();
            String sizeUnit;
            double size;
            if (fileSize < 1024) {
                sizeUnit = "bytes";
                size = fileSize;
            } else if (fileSize < 1024 * 1024) {
                sizeUnit = "KB";
                size = fileSize / 1024.0;
            } else {
                sizeUnit = "MB";
                size = fileSize / (1024.0 * 1024.0);
            }

            // Xuất ra màn hình thông tin độ lớn của file
            System.out.println("Độ lớn của file là: " + size + " " + sizeUnit);
        } else {
            System.out.println("File không tồn tại.");
        }
    }
}
