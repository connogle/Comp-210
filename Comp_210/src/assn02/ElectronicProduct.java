package assn02;

public class ElectronicProduct {
    String _dayOfCreation;
    String _timeMade;
    String _category;
    float _fee;
    int _quantity;
    float _time;
    float _cost;
    public void create(String[] item) {
        _dayOfCreation = item[0];
        _timeMade=item[1];
        _category=item[2];
        _fee=Float.parseFloat(item[3]);
        _quantity=Integer.parseInt(item[4]);
        _time=Float.parseFloat(item[5]);
        _cost=Float.parseFloat(item[6]);
    }
}
