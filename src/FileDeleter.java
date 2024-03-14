import java.io.File;
import java.util.Scanner;

public class FileDeleter {
    public static void main(String[] args) {
        // Nhập đường dẫn của thư mục hoặc file từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn của thư mục hoặc file để xoá: ");
        String path = scanner.nextLine();
        scanner.close();

        // Tạo một đối tượng File từ đường dẫn được nhập
        File fileToDelete = new File(path);

        // Kiểm tra xem đường dẫn tồn tại hay không
        if (fileToDelete.exists()) {
            // Kiểm tra xem đường dẫn là thư mục hay tập tin
            if (fileToDelete.isDirectory()) {
                // Nếu là thư mục, sử dụng phương thức đệ quy để xoá tất cả các tập tin và thư mục bên trong
                deleteDirectory(fileToDelete);
            } else {
                // Nếu là tập tin, xoá trực tiếp
                fileToDelete.delete();
                System.out.println("Đã xoá file thành công.");
            }
        } else {
            System.out.println("Đường dẫn không tồn tại.");
        }
    }

    // Phương thức đệ quy để xoá tất cả các tập tin và thư mục bên trong một thư mục
    private static void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Nếu là thư mục, gọi đệ quy để xoá tất cả các tập tin và thư mục bên trong
                    deleteDirectory(file);
                } else {
                    // Nếu là tập tin, xoá trực tiếp
                    file.delete();
                }
            }
        }
        // Sau khi xoá hết các tập tin và thư mục bên trong, xoá thư mục hiện tại
        directory.delete();
        System.out.println("Đã xoá thư mục thành công.");
    }
}
