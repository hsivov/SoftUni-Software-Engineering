package Polymorphism.word;

public class PasteImpl implements TextTransform{
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            text.insert(startIndex, CutImpl.getClipboard());
            return;
        }
        text.replace(startIndex, endIndex, CutImpl.getClipboard());
    }
}
