package Polymorphism.word;

public class CutImpl implements TextTransform {

    private static String clipboard;
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            clipboard = "";
            return;
        }

        clipboard = text.substring(startIndex, endIndex);
        text.delete(startIndex, endIndex);
    }

    public static String getClipboard() {
        return clipboard;
    }
}
