package Lab1;

public class ChewingGum extends Food{
    private String flavour;
    public ChewingGum(String flavour)
    {
        super("Жевательная резинка");
        this.flavour = flavour;
    }
    public double calculateCalories()
    {
        if(flavour.equals("Арбуз"))
        {
            return 54;
        }
        else
            if(flavour.equals("Мята"))
            {
                return 19;
            }
            else
            {
                return 20;
            }
    }
    public void consume()
    {
        System.out.println(this + " с привкусом: " + "'" + flavour + "'" + " и калорийностью " + "'" + calculateCalories() + "'" +  " съедена");
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof ChewingGum)) return false; // Шаг 2
            return flavour.equals(((ChewingGum)arg0).flavour); // Шаг 3
        } else
            return false;
    }
}
