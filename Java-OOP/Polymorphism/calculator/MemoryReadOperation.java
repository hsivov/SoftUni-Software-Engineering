package Polymorphism.calculator;

import java.util.Deque;

public class MemoryReadOperation implements Operation{

    private Deque<Integer> memory;

    public MemoryReadOperation(Deque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        //this method is not used on to memory read
    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
