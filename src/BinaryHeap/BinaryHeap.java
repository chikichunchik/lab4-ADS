package BinaryHeap;


import java.util.*;

public class BinaryHeap <E extends Comparable<E>> implements Iterable<E>{
    ArrayList<E> elements;

    public BinaryHeap() {
        this.elements = new ArrayList<E>();
    }

    @Override
    public Iterator<E> iterator() {
        return new HeapIterator<E>();
    }

    private class HeapIterator <T extends Comparable<T>> implements Iterator<T>{

        private int current;

        public HeapIterator(){
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            if(current < elements.size()){
                return true;
            } else {
                return false;
            }
        }

        @Override
        public T next() {
            return (T) elements.get(current++);
        }
    }

    public void add(E element){
        elements.add(element);
        stabilizeUp(elements.size() - 1);
    }

    public E find(E element){
        for(E currentElement : elements){
            if(element.compareTo(currentElement) == 0){
                return currentElement;
            }
        }
        return null;
    }

    public void remove(E element){
        int index = elements.indexOf(element);
        if(index == -1) { throw new NoSuchElementException(); }

        if(index != elements.size() - 1){
            E temp = elements.get(index);
            elements.set(index, elements.get(elements.size() - 1));
            elements.set(elements.size() - 1, temp);
            stabilizeDown(index);
            stabilizeUp(index);
        }
        elements.remove(elements.size() - 1);
    }

    public List<E> getSortedList(){
        ArrayList<E> sortedList = new ArrayList<>(elements);
        sortedList.sort(Comparable::compareTo);
        return sortedList;
    }

    @Override
    public String toString(){
        return elements.toString();
    }

    private void stabilizeUp(Integer index) {
        int current = index;
        while(current > 0){
            int next = (current - 1)/2;
            E element = elements.get(current);
            E parent = elements.get(next);
            if(element.compareTo(parent) > 0){
                elements.set(current, parent);
                elements.set(next, element);
                current = next;
            } else {
                break;
            }
        }
    }

    private void stabilizeDown(Integer index){
        int leftIndex = 2*index + 1;
        int rightIndex = leftIndex + 1;
        int current = index;

        if(leftIndex < elements.size()
                && elements.get(leftIndex).compareTo(elements.get(current)) > 0){
            current = leftIndex;
        }

        if(rightIndex < elements.size()
                && elements.get(rightIndex).compareTo(elements.get(current)) > 0){
            current = rightIndex;
        }

        if(current == index) { return; }

        E temp = elements.get(index);
        elements.set(index, elements.get(current));
        elements.set(current, temp);
        stabilizeDown(current);
    }


}
