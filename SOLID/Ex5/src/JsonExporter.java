import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // inconsistent handling (surprise)
        if (req == null || req.body == null) {
            return ExportResult.error("Invalid export request");
        }

         String json = "{\"title\":\"" + escape(req.title) +
                      "\",\"body\":\"" + escape(req.body) + "\"}";

        return new ExportResult(
                "application/json",
                json.getBytes(StandardCharsets.UTF_8)
        );
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}
