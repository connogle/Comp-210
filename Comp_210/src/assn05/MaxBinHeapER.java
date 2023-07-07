package assn05;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxBinHeapER  <V, P extends Comparable<P>> implements BinaryHeap<V, P> {

    private List<Prioritized<V,P>> _heap;
    /**
     * Constructor that creates an empty heap of hospital.Prioritized objects.
     */
    public MaxBinHeapER() {
        _heap = new ArrayList<>();
    }

    /**
     * Constructor that builds a heap given an initial array of hospital.Prioritized objects.
     */
    // TODO: overloaded constructor
    public MaxBinHeapER(Prioritized<V, P>[] initialEntries ) {
        _heap = Arrays.asList(initialEntries);
        for (int i = (initialEntries.length-2)/2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public void bubbleDown(int i) {

        int largest = i;
        int l = i*2+1;
        int r = i*2+2;
        int size = size();

        if ((l < size && _heap.get(l).getPriority().compareTo(_heap.get(i).getPriority()) > 0) && (r < size && _heap.get(r).getPriority().compareTo(_heap.get(i).getPriority()) > 0)) {
            if (_heap.get(l).getPriority().compareTo(_heap.get(r).getPriority())>0) {
                largest = l;
            } else {
                largest = r;
            }
        }
        else if (l < size && _heap.get(l).getPriority().compareTo(_heap.get(i).getPriority()) > 0) {
            largest = l;
        } else if (r < size && _heap.get(r).getPriority().compareTo(_heap.get(i).getPriority()) > 0) {
            largest = r;
        }
        if (i != largest) {
            Prioritized<V, P> temporary = _heap.get(i);
            _heap.set(i, _heap.get(largest));
            _heap.set(largest, temporary);
            bubbleDown(largest);
        }
    }

    @Override
    public int size() {
        return _heap.size();
    }

    // TODO: enqueue
    @Override
    public void enqueue(V value, P priority) {
        _heap.add(new Patient<>(value, priority));
        bubbleUp((Patient<V, P>) _heap.get(size()-1), size()-1);
    }

    // TODO: enqueue
    public void enqueue(V value) {
        _heap.add(new Patient<>(value));
        bubbleUp((Patient<V, P>) _heap.get(size()-1), size()-1);
    }

    public void bubbleUp(Patient<V, P> patient, int index) {
        if (index == 0) { return; }
        if ((patient.getPriority().compareTo(_heap.get((index-1)/2).getPriority()) > 0)) {
            _heap.set(index, _heap.get((index-1) / 2));
            _heap.set((index-1) / 2, patient);
            bubbleUp(patient, (index-1) / 2);
        }
    }

    // TODO: dequeue
    @Override
    public V dequeue() {
        if (size() == 0) {
            return null;
        }
        Prioritized<V, P> toRemove = _heap.set(0, _heap.get(_heap.size()-1));
        _heap.remove(_heap.size()-1);
        if (size() > 0) {
            bubbleDown( 0);
        }
        return toRemove.getValue();
    }


    // TODO: getMax
    @Override
    public V getMax() {
        if (size() == 0) {
            return null;
        }
        return _heap.get(0).getValue();
    }
    @Override
    public Prioritized<V, P>[] getAsArray() {
        Prioritized<V,P>[] result = (Prioritized<V, P>[]) Array.newInstance(Prioritized.class, size());
        return _heap.toArray(result);
    }

    public P getMaxPriority() {
        if (size() == 0) {
            return null;
        }
        return _heap.get(0).getPriority();
    }

}
