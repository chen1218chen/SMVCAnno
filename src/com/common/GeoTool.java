package com.common;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

public class GeoTool {
	public static int SRID=4326;
	public static Point createPoint(String coord){  
		WKTReader fromText = new WKTReader();
		Point pt=null;
		Geometry geom = null;
        try {
        	geom = fromText.read(coord);
        } catch (ParseException e) {
            throw new RuntimeException("Not a WKT string:" + coord);
        }
        if (!geom.getGeometryType().equals("Point")) {
            throw new RuntimeException("Geometry must be a point. Got a " + geom.getGeometryType());
        }
        pt=(Point)geom;
        pt.setSRID(SRID);
        return pt;  
    }
}
