
public class Filename {
    private String fullPath;
    private char pathSeparator;
    private char extensionSeparator;

    public Filename(String str, char sep, char ext) {
        this.fullPath = str;
        this.pathSeparator = sep;
        this.extensionSeparator = ext;
    }

    public String extension() {
        int dot = this.fullPath.lastIndexOf(this.extensionSeparator);
        return this.fullPath.substring(dot + 1);
    }

    // gets filename without extension
    public String filename() {
        int dot = this.fullPath.lastIndexOf(this.extensionSeparator);
        int sep = this.fullPath.lastIndexOf(this.pathSeparator);
        return this.fullPath.substring(sep + 1, dot);
    }

    public String path() {
        int sep = this.fullPath.lastIndexOf(this.pathSeparator);
        return this.fullPath.substring(0, sep);
    }
}
