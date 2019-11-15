/*1.1	Задание. 1. Управление файловой структурой Java – класс File.
Требуется выполнить три упражнения. Результаты каждого упражнения включить в отчет по лабораторной работе.
Все упражнения задания реализовать в одном проекте в методе main, разделяя код упражнений комментариями – условие упражнения.
*/

import java.io.File;
import java.nio.file.Files;

public class Task_1 {
    public void start_task_1(){

        System.out.println("Упражнение 1");
        /*Упражнение 1:
        *Исследовать возможности класса File по созданию файлов (пустых) и папок программой. Применение конструктора и метода.
•	Создать файл в папке приложения с именем MyFile1.txt.
•	Проверить появление файла в папке приложения.
•	Создать файл с именем MyFile2.txt в корне определенного диска.
•	Проверить появление файла в папке.
•	Создать файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла.
•	Проверить появление файла в папке.
•	Создать папку третьего уровня, например, Первая\\Вторая\\Третья.
•	Проверить появление папки.
•	Все операции заключить в блок try, с обработчиками исключений IOException, Exception, FileNotFoundException.
 */

        try {
            //создаем файл
            File F1 = new File("MyFile1.txt");

            if(F1.createNewFile())
                System.out.println("Файл в папке проекта существует");
            else
                System.out.println("Файл в папке проекта НЕ существует");

            F1.deleteOnExit();

        }catch (Exception io){
            System.out.println("Error 1" + io);
        }

        try {
            //создаем файл в корне диска С
            //будет отказано в доступе, если это системный диск
            File F2 = new File("C:\\MyFile2.txt");

            if(F2.createNewFile())
                System.out.println("Файл в корне диска существует");
            else
                System.out.println("Файл в корне диска НЕ существует");

            F2.deleteOnExit();

        }catch (Exception io){
            System.out.println("Error 2 " + io);
        }

        try {
            //создаем файл с именем MyFile3.txt в папке Имя диска\\Имя папки\\Имя файла
            File F3 = new File("C:\\Test\\MyFile3.txt");

            if(F3.createNewFile())
                System.out.println("Файл в папке имя диска \\ Имя папки \\ Имя файла существует");
            else
                System.out.println("Файл в папке проекта имя диска \\ Имя папки \\ Имя файла НЕ существует");

            F3.deleteOnExit();
        }catch (Exception io){
            System.out.println("Error 3 " + io);
        }

        try {
            //создаеим каталог папок первая\вторая\третья на диске С
            File F4 = new File("C:\\Первая\\Вторая\\Третья");
            if(F4.mkdirs())
                System.out.println("Удалось создать каталог ");
            else
                System.out.println("НЕ удалось создать каталог ");

            F4.deleteOnExit();
        }
        catch (Exception io){
            System.out.println("Error 4 " + io);
        }


        System.out.println("\n\nУпражнение 2");
        /*Упражнение 2. Получить параметры файлов методами класса File.
В пунктах задания использовать объекты, созданные в задании 1.
•	Проверить, что вызывающий объект содержит имя файла, а не папки и
отобразить имя файла, вызывающего объекта и его родительскую папку.
•	Проверить, что вызывающий объект содержит имя папки, а не файла и
отобразить имя файла, вызывающего объекта.
•	Проверить, что в папке приложения существует файл с именем MyFile1.txt.
•	Отобразить полный путь к файлу или папке объекта.
•	Отобразить размер файла или папки объекта, указать единицу измерения. Прокомментировать вид файла – папка или файл.
*/

        //проверим по-очереди F1 F2 F3
        try {
            //F1
            File F1 = new File("MyFile1.txt");

            if(Files.isRegularFile(F1.toPath())){
                System.out.println(F1.toPath());
            }
            else
                System.out.println("Вывзывающий объект не содержит имя файла");


        }catch (Exception io){
            System.out.println("Error 1" + io);
        }

        try {
            //F2
            File F2 = new File("C:\\MyFile2.txt");

            if(Files.isRegularFile(F2.toPath())){
                System.out.println(F2.toPath());
            }
            else
                System.out.println("Вывзывающий объект не содержит имя файла");

        }catch (Exception io){
            System.out.println("Error 2" + io);
        }

        try {
            //F3
            File F3 = new File("C:\\Test\\MyFile3.txt");

            if(Files.isRegularFile(F3.toPath())){
                System.out.println(F3.toPath());
            }
            else
                System.out.println("Вывзывающий объект не содержит имя файла");

        }catch (Exception io){
            System.out.println("Error 3" + io);
        }


        try {
            //F4
            File F4 = new File("C:\\Первая\\Вторая\\Третья");

            if(Files.isRegularFile(F4.toPath())){
                System.out.println(F4.toPath());
            }
            else
                System.out.println("Вывзывающий объект не содержит имя файла");

        }catch (Exception io){
            System.out.println("Error 4" + io);
        }

        System.out.println("\n\nУпражнение 3");

        /*Упражнение 3. Модификация файловой структуры приложения средствами класса File.
1.	Добавить в папку приложения еще одну папку.
2.	Сформировать массив файлов, находящихся в папке приложения, используя метод list(). Отобразить содержимое массива.
3.	Сформировать массив файлов, находящихся в папке приложения, используя метод listFiles( ).
    Отобразить содержимое массива. Определить количество папок, содержащихся в файле приложения.
4.	Удалить папки и файлы созданные во всех трех упражнениях
*/

        try{
            // добавим новую папку в приложении
            File F5 = new File("My_folder");
            F5.mkdir();
            System.out.println("Папка добавлена");

            F5.deleteOnExit();
        }
        catch (Exception io){
            System.out.println("Error 5" + io);
        }

        try {
            // сформируем массив файлов в папке приложения с помощью list
            File F6 = new File(System.getProperty("user.dir"));
            String[] paths = F6.list();


            System.out.print("Файлы папки приложения: ");
            // и выведем на экран
            for(String path : paths){
                System.out.print(path+" , ");
            }
            System.out.println();

            F6.deleteOnExit();

        }catch (Exception io){
            System.out.println("Error 6 " + io);
        }

        try {
            // сформируем массив файлов с помощью ListFiles и посчитаем сколкьо папок с помощью isDirectory()
            File F7 = new File(System.getProperty("user.dir"));
            File[] paths = F7.listFiles();

            System.out.print("Файлы папки приложения: ");
            int count_directory = 0;
            for(File path : paths){
                System.out.print(path.getName()+" , ");
                if(path.isDirectory())
                    count_directory++;
            }
            System.out.println("    Из них папок " + count_directory + "\n\n\n");

            F7.deleteOnExit();


        }catch (Exception io){
            System.out.println("Error 7 "+io);
        }

        // все созданные файлы удаляются в конце с помощью метода deleteOnExit()

    }
}
