package Lab1;

import java.util.Arrays;

public class MainApplication {
    // Конструктор класса отсутствует!!!
    // Главный метод главного класса
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        int howManyBigApples = 0;
        int howManyLittleApples = 0;
        int howManyMiddleApples = 0;
        int howManyCheeses = 0;
        int howManyWaterMelonChewingGums = 0;
        int howManyMentholChewingGums = 0;
        int howManyCherryChewingGums = 0;
        double howManyCaloriesInBreakfast = 0;
        for (String arg: args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
                howManyCheeses++;
            } else
            if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
                if(parts[1].equals("Большой"))
                {
                    howManyBigApples++;
                }
                else
                    if(parts[1].equals("Малый"))
                    {
                        howManyLittleApples++;
                    }
                    else
                        if(parts[1].equals("Средний"))
                        {
                            howManyMiddleApples++;
                        }
            }
            else
                if(parts[0].equals("ChewingGum"))
                {
                    breakfast[itemsSoFar] = new ChewingGum(parts[1]);
                    if(parts[1].equals("Арбуз"))
                    {
                        howManyWaterMelonChewingGums++;
                    }
                    else
                        if(parts[1].equals(("Вишня")))
                        {
                            howManyCherryChewingGums++;
                        }
                        else
                            if(parts[1].equals("Мята"))
                            {
                                howManyMentholChewingGums++;
                            }
                }
// ... Продолжается анализ других продуктов для завтрака
            itemsSoFar++;
        }
// Перебор всех элементов массива
        for (Food item: breakfast)
            if (item!=null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
            if(howManyBigApples != 0)
            {
                System.out.println("Съедено больших яблок:" + howManyBigApples);
            }
            if(howManyLittleApples != 0)
            {
                System.out.println("Съедено маленьких яблок:" + howManyLittleApples);
            }
            if(howManyMiddleApples != 0)
            {
                System.out.println("Съедено яблок среднего размера:" + howManyMiddleApples);
            }
            if(howManyWaterMelonChewingGums !=0)
            {
                System.out.println("Съедено жевательных резинок с Арбузом:" + howManyWaterMelonChewingGums);
            }
            if(howManyCherryChewingGums != 0)
            {
                System.out.println("Съедено жевательных резинок с Вишней:" + howManyCherryChewingGums);
            }
            if(howManyMentholChewingGums != 0)
            {
                System.out.println("Съедено жевательных резинок с Мятой:" + howManyMentholChewingGums);
            }
            if(howManyCheeses != 0)
            {
                System.out.println("Съедено ломтиков сыра:" + howManyCheeses);
            }
            if(itemsSoFar != 0)
            {
                System.out.println("Съедено всего продуктов: " + itemsSoFar);
            }
            for(String arg: args)
            {
                    if(arg.equals("-calories"))
                    {
                        for (Food item: breakfast)
                            if (item!=null)
                               howManyCaloriesInBreakfast+= item.calculateCalories();
                            else
                                break;
                            System.out.println("Общая калорийность завтрака: " + howManyCaloriesInBreakfast);
                    }
                    else if(arg.equals("-sort"))
                    {
                        Arrays.sort(breakfast, new FoodComparator());
                        System.out.println("Отсортированный вариант:");
                        for(Food item: breakfast)
                        {
                            if(item!=null)
                            {
                                System.out.println(item.getName() + " "+ item.calculateCalories());
                            }
                            else
                                break;
                        }
                    }

            }
        System.out.println("Всего хорошего!");
    }

}
