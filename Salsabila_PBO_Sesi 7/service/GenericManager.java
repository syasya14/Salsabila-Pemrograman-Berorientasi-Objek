package service;
import java.util.ArrayList;
import java.util.List;

// Interface untuk abstraksi
interface IOperation<T> {
    void add(T data);
    void displayAll();
}

// Konsep Generic & Collection (ArrayList) sesuai soal No. 2 & 3
public class GenericManager<T> implements IOperation<T> {
    private List<T> list = new ArrayList<>();

    @Override
    public void add(T data) {
        list.add(data);
    }

    @Override
    public void displayAll() {
        for (T item : list) {
            // Polymorphism: memanggil info() jika item adalah Mahasiswa
            if (item instanceof model.Mahasiswa) {
                ((model.Mahasiswa<?, ?, ?>) item).info();
            }
        }
    }
}