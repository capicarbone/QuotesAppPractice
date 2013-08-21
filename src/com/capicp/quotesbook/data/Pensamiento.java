package com.capicp.quotesbook.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by capi on 28/06/13.
 */
public class Pensamiento implements Parcelable{

    private long id;
    private String cita;
    private String autor_nombre;
    private String autor_descripcion;
    private String autor_foto;

    public Pensamiento(){

    }

    public Pensamiento(Parcel in){
        readFromParcel(in);
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = cita;
    }

    public String getAutor_nombre() {
        return autor_nombre;
    }

    public void setAutor_nombre(String autor_nombre) {
        this.autor_nombre = autor_nombre;
    }

    public String getAutor_descripcion() {
        return autor_descripcion;
    }

    public void setAutor_descripcion(String autor_descripcion) {
        this.autor_descripcion = autor_descripcion;
    }

    public String getAutor_foto() {
        return autor_foto;
    }

    public void setAutor_foto(String autor_foto) {
        this.autor_foto = autor_foto;
    }

    public String toString(){
        return "La cita es: " + getCita();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public static final Parcelable.Creator<Pensamiento> CREATOR= new Parcelable.Creator<Pensamiento>() {
    		public Pensamiento createFromParcel(Parcel in) {
    				return new Pensamiento(in);
    		}
    		
    		public Pensamiento[] newArray(int size) {
                return new Pensamiento[size];
            }
        };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeLong(id);
        dest.writeString(cita);
        dest.writeString(autor_nombre);
        dest.writeString(autor_descripcion);
        dest.writeString(autor_foto);
    }

    public void readFromParcel(Parcel in){
        id = in.readLong();
        cita = in.readString();
        autor_nombre = in.readString();
        autor_descripcion = in.readString();
        autor_foto = in.readString();
    }
}
