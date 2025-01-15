package com.daniel.plugins.cleancache;

import android.content.Context;
import android.os.StatFs;
import android.util.Log;

import com.getcapacitor.Bridge;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "CleanCache")
public class CleanCache extends Plugin{

   // Método para limpiar la caché de la aplicación
   public void clearAppCache(Context context) {
    try {
        File cacheDir = context.getCacheDir();
        deleteDir(cacheDir);
        Log.d("CacheCleaner", "Caché de la app limpiada.");
    } catch (Exception e) {
        Log.e("CacheCleaner", "Error al limpiar la caché de la app", e);
    }
}

// Método recursivo para eliminar archivos
private boolean deleteDir(File dir) {
    if (dir != null && dir.isDirectory()) {
        String[] children = dir.list();
        for (String child : children) {
            boolean success = deleteDir(new File(dir, child));
            if (!success) {
                return false;
            }
        }
    }
    return dir.delete();
}

// Método para optimizar la memoria
public void optimizeMemory(Context context) {
    try {
        StatFs statFs = new StatFs(context.getFilesDir().getAbsolutePath());
        long blockSize = statFs.getBlockSizeLong();
        long availableBlocks = statFs.getAvailableBlocksLong();
        long availableMemory = blockSize * availableBlocks;
        Log.d("CacheCleaner", "Memoria disponible: " + availableMemory / (1024 * 1024) + " MB");

        // Aquí podrías agregar más lógica si necesitas liberar memoria adicional
    } catch (Exception e) {
        Log.e("CacheCleaner", "Error al optimizar la memoria", e);
    }
}

// Método para invocar desde JavaScript
@PluginMethod
public void clearCache(PluginCall call) {
    clearAppCache(getContext());
    call.resolve();
}

// Método para invocar desde JavaScript
@PluginMethod
public void optimizeDevice(PluginCall call) {
    optimizeMemory(getContext());
    call.resolve();
}
}
