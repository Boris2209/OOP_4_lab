import java.util.Scanner;

public class Main {
    public static void main(String[] ags){

        Task_1 t1 = new Task_1();

        Task_2 t2 = new Task_2();

        Task_3 t3 = new Task_3();

        String main_menu_text = "1. Задание 1: Класс File\n2. Задание 2: Байтовые потоки\n3. Задание 3: Символьные потоки\n0. Выход\n";
        int job_program = -1;
        while (job_program!=0){
            System.out.println(main_menu_text);
            Scanner m_sc = new Scanner(System.in);
            job_program = m_sc.nextInt();
            switch (job_program){
                case 1:
                    t1.start_task_1();
                    break;

                case 2:
                    t2.show_menu_2();
                    break;

                case 3:
                    t3.start_task_3();
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Введена неверная команда, повторите ввод");
                    break;
            }
        }
    }


}
