import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Book> bookList;
    private  String name;

    public Student(String name, List<Book> bookList) {
        this.name = name;
        this.bookList = new ArrayList<>(bookList);
    }

    @Override
    public String toString() {
        return "Имя: " + name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public static void main(String[] args) {

        Student ivanov = new Student("Иван", List.of(
                new Book("Лев Толстой", "Война и мир", 1300, 1869),
                new Book("Фёдор Достоевский", "Преступление и наказание", 672, 1866),
                new Book("Михаил Булгаков", "Мастер и Маргарита", 480, 1940),
                new Book("Уильям Шекспир", "Ромео и Джульетта", 256, 1597),
                new Book("Александр Пушкин", "Евгений Онегин", 200, 1833)
        ));

        Student petrov = new Student("Петр", List.of(
                new Book("Николай Гоголь", "Мертвые души", 416, 1842),
                new Book("Александр Грибоедов", "Горе от ума", 192, 1825),
                new Book("Иван Гончаров", "Обломов", 560, 1859),
                new Book("Михаил Лермонтов", "Герой нашего времени", 288, 1840),
                new Book("Антон Чехов", "Вишневый сад", 96, 1904)
        ));

        List<Student> allStudents = new ArrayList<>();
        allStudents.add(ivanov);
        allStudents.add(petrov);

        allStudents.stream()
                .peek(student -> System.out.println(student))
                .flatMap(student -> student.getBookList().stream())
                .forEach(book -> System.out.println(book));
    }
}
