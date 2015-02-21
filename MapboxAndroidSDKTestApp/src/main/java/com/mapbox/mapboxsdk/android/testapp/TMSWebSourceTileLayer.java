package com.mapbox.mapboxsdk.android.testapp;

import com.mapbox.mapboxsdk.tileprovider.MapTile;
import com.mapbox.mapboxsdk.tileprovider.tilesource.WebSourceTileLayer;

public class TMSWebSourceTileLayer extends WebSourceTileLayer {
    public TMSWebSourceTileLayer(String pId, String url) {
        super(pId, url);
    }

    public TMSWebSourceTileLayer(String pId, String url, boolean enableSSL) {
        super(pId, url, enableSSL);
    }

    @Override
    public String getTileURL(final MapTile aTile, boolean hdpi) {
        int y = (1 << aTile.getZ()) - aTile.getY() - 1;
        return mUrl.replace("{z}", String.valueOf(aTile.getZ()))
                .replace("{x}", String.valueOf(aTile.getX()))
                .replace("{y}", String.valueOf(y))
                .replace("{2x}", hdpi ? "@2x" : "");
    }
}
