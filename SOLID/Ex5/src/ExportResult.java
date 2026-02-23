public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    public final String error;

    public ExportResult(String contentType, byte[] bytes) {
        this.contentType = contentType;
        this.bytes = bytes;
        this.error = null;
    }

    public static ExportResult error(String error) {
        return new ExportResult("ERROR", new byte[0]);
    }
}
