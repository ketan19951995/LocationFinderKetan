package com.tayal.locationfinderketan;

/**
 * Created by lirisha on 15-01-2017.
 */


public class UpdateItem {
    String name;
    String vicinity;
    String lat;
    String lng;
    String reference ;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;

    }
    public String getVicinity() {
        return vicinity;
    }

    public void setreference(String reference){
        this.reference= reference;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getreference(){
        return reference;
    }
    public String getlat() {
        return lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getlng() {
        return lng;
    }


}
