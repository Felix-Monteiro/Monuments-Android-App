/*-----------------------------------------------------------------------------
 - Developed by Felix Saraiva                                                 -
 - Last modified 3/17/19 5:24 AM                                              -                        -
 - Copyright (c) 2019. All rights reserved                                    -
 -----------------------------------------------------------------------------*/
package com.thunder.project.model;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Places {

    @SerializedName("places")
    @Expose
    private List<Place> places = null;

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public class Place {
        @SerializedName("idPlace")
        @Expose
        private String idPlace;
        @SerializedName("strPlace")
        @Expose
        private String strPlace;
        @SerializedName("strDrinkAlternate")
        @Expose
        private Object strDrinkAlternate;
        @SerializedName("strCategory")
        @Expose
        private String strLocation;
        @SerializedName("strArea")
        @Expose
        private String strArea;
        @SerializedName("strHistory")
        @Expose
        private String strHistory;
        @SerializedName("strPlaceThumb")
        @Expose
        private String strPlaceThumb;
        @SerializedName("strTags")
        @Expose
        private String strTags;
        @SerializedName("strYoutube")
        @Expose
        private String strYoutube;
        @SerializedName("strProperty1")
        @Expose
        private String strProperty1;
        @SerializedName("strProperty2")
        @Expose
        private String strProperty2;
        @SerializedName("strProperty3")
        @Expose
        private String strProperty3;
        @SerializedName("strProperty4")
        @Expose
        private String strProperty4;
        @SerializedName("strProperty5")
        @Expose
        private String strProperty5;
        @SerializedName("strProperty6")
        @Expose
        private String strProperty6;
        @SerializedName("strProperty7")
        @Expose
        private String strProperty7;
        @SerializedName("strProperty8")
        @Expose
        private String strProperty8;
        @SerializedName("strProperty9")
        @Expose
        private String strProperty9;
        @SerializedName("strProperty10")
        @Expose
        private String strProperty10;
        @SerializedName("strProperty11")
        @Expose
        private String strProperty11;
        @SerializedName("strProperty12")
        @Expose
        private String strProperty12;
        @SerializedName("strProperty13")
        @Expose
        private String strProperty13;
        @SerializedName("strProperty14")
        @Expose
        private String strProperty14;
        @SerializedName("strProperty15")
        @Expose
        private String strProperty15;
        @SerializedName("strProperty16")
        @Expose
        private String strProperty16;
        @SerializedName("strProperty17")
        @Expose
        private String strProperty17;
        @SerializedName("strProperty18")
        @Expose
        private String strProperty18;
        @SerializedName("strProperty19")
        @Expose
        private String strProperty19;
        @SerializedName("strProperty20")
        @Expose
        private String strProperty20;
        @SerializedName("strMeasure1")
        @Expose
        private String strMeasure1;
        @SerializedName("strMeasure2")
        @Expose
        private String strMeasure2;
        @SerializedName("strMeasure3")
        @Expose
        private String strMeasure3;
        @SerializedName("strMeasure4")
        @Expose
        private String strMeasure4;
        @SerializedName("strMeasure5")
        @Expose
        private String strMeasure5;
        @SerializedName("strMeasure6")
        @Expose
        private String strMeasure6;
        @SerializedName("strMeasure7")
        @Expose
        private String strMeasure7;
        @SerializedName("strMeasure8")
        @Expose
        private String strMeasure8;
        @SerializedName("strMeasure9")
        @Expose
        private String strMeasure9;
        @SerializedName("strMeasure10")
        @Expose
        private String strMeasure10;
        @SerializedName("strMeasure11")
        @Expose
        private String strMeasure11;
        @SerializedName("strMeasure12")
        @Expose
        private String strMeasure12;
        @SerializedName("strMeasure13")
        @Expose
        private String strMeasure13;
        @SerializedName("strMeasure14")
        @Expose
        private String strMeasure14;
        @SerializedName("strMeasure15")
        @Expose
        private String strMeasure15;
        @SerializedName("strMeasure16")
        @Expose
        private String strMeasure16;
        @SerializedName("strMeasure17")
        @Expose
        private String strMeasure17;
        @SerializedName("strMeasure18")
        @Expose
        private String strMeasure18;
        @SerializedName("strMeasure19")
        @Expose
        private String strMeasure19;
        @SerializedName("strMeasure20")
        @Expose
        private String strMeasure20;
        @SerializedName("strSource")
        @Expose
        private String strSource;
        @SerializedName("dateModified")
        @Expose
        private Object dateModified;

        public String getIdPlace() {
            return idPlace;
        }

        public void setIdPlace(String idPlace) {
            this.idPlace = idPlace;
        }

        public String getStrPlace() {
            return strPlace;
        }

        public void setStrPlace(String strPlace) {
            this.strPlace = strPlace;
        }

        public Object getStrDrinkAlternate() {
            return strDrinkAlternate;
        }

        public void setStrDrinkAlternate(Object strDrinkAlternate) {
            this.strDrinkAlternate = strDrinkAlternate;
        }

        public String getStrLocation() {
            return strLocation;
        }

        public void setStrLocation(String strLocation) {
            this.strLocation = strLocation;
        }

        public String getStrArea() {
            return strArea;
        }

        public void setStrArea(String strArea) {
            this.strArea = strArea;
        }

        public String getStrHistory() {
            return strHistory;
        }

        public void setStrHistory(String strHistory) {
            this.strHistory = strHistory;
        }

        public String getStrPlaceThumb() {
            return strPlaceThumb;
        }

        public void setStrPlaceThumb(String strPlaceThumb) {
            this.strPlaceThumb = strPlaceThumb;
        }

        public String getStrTags() {
            return strTags;
        }

        public void setStrTags(String strTags) {
            this.strTags = strTags;
        }

        public String getStrYoutube() {
            return strYoutube;
        }

        public void setStrYoutube(String strYoutube) {
            this.strYoutube = strYoutube;
        }

        public String getStrProperty1() {
            return strProperty1;
        }

        public void setStrProperty1(String strProperty1) {
            this.strProperty1 = strProperty1;
        }

        public String getStrProperty2() {
            return strProperty2;
        }

        public void setStrProperty2(String strProperty2) {
            this.strProperty2 = strProperty2;
        }

        public String getStrProperty3() {
            return strProperty3;
        }

        public void setStrProperty3(String strProperty3) {
            this.strProperty3 = strProperty3;
        }

        public String getStrProperty4() {
            return strProperty4;
        }

        public void setStrProperty4(String strProperty4) {
            this.strProperty4 = strProperty4;
        }

        public String getStrProperty5() {
            return strProperty5;
        }

        public void setStrProperty5(String strProperty5) {
            this.strProperty5 = strProperty5;
        }

        public String getStrProperty6() {
            return strProperty6;
        }

        public void setStrProperty6(String strProperty6) {
            this.strProperty6 = strProperty6;
        }

        public String getStrProperty7() {
            return strProperty7;
        }

        public void setStrProperty7(String strProperty7) {
            this.strProperty7 = strProperty7;
        }

        public String getStrProperty8() {
            return strProperty8;
        }

        public void setStrProperty8(String strProperty8) {
            this.strProperty8 = strProperty8;
        }

        public String getStrProperty9() {
            return strProperty9;
        }

        public void setStrProperty9(String strProperty9) {
            this.strProperty9 = strProperty9;
        }

        public String getStrProperty10() {
            return strProperty10;
        }

        public void setStrProperty10(String strProperty10) {
            this.strProperty10 = strProperty10;
        }

        public String getStrProperty11() {
            return strProperty11;
        }

        public void setStrProperty11(String strProperty11) {
            this.strProperty11 = strProperty11;
        }

        public String getStrProperty12() {
            return strProperty12;
        }

        public void setStrProperty12(String strProperty12) {
            this.strProperty12 = strProperty12;
        }

        public String getStrProperty13() {
            return strProperty13;
        }

        public void setStrProperty13(String strProperty13) {
            this.strProperty13 = strProperty13;
        }

        public String getStrProperty14() {
            return strProperty14;
        }

        public void setStrProperty14(String strProperty14) {
            this.strProperty14 = strProperty14;
        }

        public String getStrProperty15() {
            return strProperty15;
        }

        public void setStrProperty15(String strProperty15) {
            this.strProperty15 = strProperty15;
        }

        public String getStrProperty16() {
            return strProperty16;
        }

        public void setStrProperty16(String strProperty16) {
            this.strProperty16 = strProperty16;
        }

        public String getStrProperty17() {
            return strProperty17;
        }

        public void setStrProperty17(String strProperty17) {
            this.strProperty17 = strProperty17;
        }

        public String getStrProperty18() {
            return strProperty18;
        }

        public void setStrProperty18(String strProperty18) {
            this.strProperty18 = strProperty18;
        }

        public String getStrProperty19() {
            return strProperty19;
        }

        public void setStrProperty19(String strProperty19) {
            this.strProperty19 = strProperty19;
        }

        public String getStrProperty20() {
            return strProperty20;
        }

        public void setStrProperty20(String strProperty20) {
            this.strProperty20 = strProperty20;
        }

        public String getStrMeasure1() {
            return strMeasure1;
        }

        public void setStrMeasure1(String strMeasure1) {
            this.strMeasure1 = strMeasure1;
        }

        public String getStrMeasure2() {
            return strMeasure2;
        }

        public void setStrMeasure2(String strMeasure2) {
            this.strMeasure2 = strMeasure2;
        }

        public String getStrMeasure3() {
            return strMeasure3;
        }

        public void setStrMeasure3(String strMeasure3) {
            this.strMeasure3 = strMeasure3;
        }

        public String getStrMeasure4() {
            return strMeasure4;
        }

        public void setStrMeasure4(String strMeasure4) {
            this.strMeasure4 = strMeasure4;
        }

        public String getStrMeasure5() {
            return strMeasure5;
        }

        public void setStrMeasure5(String strMeasure5) {
            this.strMeasure5 = strMeasure5;
        }

        public String getStrMeasure6() {
            return strMeasure6;
        }

        public void setStrMeasure6(String strMeasure6) {
            this.strMeasure6 = strMeasure6;
        }

        public String getStrMeasure7() {
            return strMeasure7;
        }

        public void setStrMeasure7(String strMeasure7) {
            this.strMeasure7 = strMeasure7;
        }

        public String getStrMeasure8() {
            return strMeasure8;
        }

        public void setStrMeasure8(String strMeasure8) {
            this.strMeasure8 = strMeasure8;
        }

        public String getStrMeasure9() {
            return strMeasure9;
        }

        public void setStrMeasure9(String strMeasure9) {
            this.strMeasure9 = strMeasure9;
        }

        public String getStrMeasure10() {
            return strMeasure10;
        }

        public void setStrMeasure10(String strMeasure10) {
            this.strMeasure10 = strMeasure10;
        }

        public String getStrMeasure11() {
            return strMeasure11;
        }

        public void setStrMeasure11(String strMeasure11) {
            this.strMeasure11 = strMeasure11;
        }

        public String getStrMeasure12() {
            return strMeasure12;
        }

        public void setStrMeasure12(String strMeasure12) {
            this.strMeasure12 = strMeasure12;
        }

        public String getStrMeasure13() {
            return strMeasure13;
        }

        public void setStrMeasure13(String strMeasure13) {
            this.strMeasure13 = strMeasure13;
        }

        public String getStrMeasure14() {
            return strMeasure14;
        }

        public void setStrMeasure14(String strMeasure14) {
            this.strMeasure14 = strMeasure14;
        }

        public String getStrMeasure15() {
            return strMeasure15;
        }

        public void setStrMeasure15(String strMeasure15) {
            this.strMeasure15 = strMeasure15;
        }

        public String getStrMeasure16() {
            return strMeasure16;
        }

        public void setStrMeasure16(String strMeasure16) {
            this.strMeasure16 = strMeasure16;
        }

        public String getStrMeasure17() {
            return strMeasure17;
        }

        public void setStrMeasure17(String strMeasure17) {
            this.strMeasure17 = strMeasure17;
        }

        public String getStrMeasure18() {
            return strMeasure18;
        }

        public void setStrMeasure18(String strMeasure18) {
            this.strMeasure18 = strMeasure18;
        }

        public String getStrMeasure19() {
            return strMeasure19;
        }

        public void setStrMeasure19(String strMeasure19) {
            this.strMeasure19 = strMeasure19;
        }

        public String getStrMeasure20() {
            return strMeasure20;
        }

        public void setStrMeasure20(String strMeasure20) {
            this.strMeasure20 = strMeasure20;
        }

        public String getStrSource() {
            return strSource;
        }

        public void setStrSource(String strSource) {
            this.strSource = strSource;
        }

        public Object getDateModified() {
            return dateModified;
        }

        public void setDateModified(Object dateModified) {
            this.dateModified = dateModified;
        }
    }
}
