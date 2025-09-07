package com.example.report;
import java.nio.file.*; import java.util.*;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;
    
    public ReportBundleFacade() {
        this.jsonWriter = new JsonWriter();
        this.zipper = new Zipper();
        this.auditLog = new AuditLog();
    }
    
    public Path export(Map<String,Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data cannot be null");
        Objects.requireNonNull(outDir, "outDir cannot be null");
        Objects.requireNonNull(baseName, "baseName cannot be null");
        
        Path jsonFile = jsonWriter.write(data, outDir, baseName);
        Path zipPath = outDir.resolve(baseName + ".zip");
        Path finalZip = zipper.zip(jsonFile, zipPath);
        auditLog.log("exported " + finalZip);
        return finalZip;
    }
}
