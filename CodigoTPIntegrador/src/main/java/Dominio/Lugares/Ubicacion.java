package Dominio.Lugares;

public class Ubicacion {
   protected String pais;
   protected String provincia;
   protected Integer localidad;
   protected String municipio;
   protected String calle;
   protected String altura;

   public Ubicacion(String pais, String provincia, Integer localidad, String municipio, String calle, String altura) {
      this.pais = pais;
      this.provincia = provincia;
      this.localidad = localidad;
      this.municipio = municipio;
      this.calle = calle;
      this.altura = altura;
   }


   public Integer getLocalidad() {
      return localidad;
   }

   public void setLocalidad(Integer localidad) {
      this.localidad = localidad;
   }


   public String getPais() {
      return pais;
   }

   public void setPais(String pais) {
      this.pais = pais;
   }

   public String getProvincia() {
      return provincia;
   }

   public void setProvincia(String provincia) {
      this.provincia = provincia;
   }


   public String getMunicipio() {
      return municipio;
   }

   public void setMunicipio(String municipio) {
      this.municipio = municipio;
   }

   public String getCalle() {
      return calle;
   }

   public void setCalle(String calle) {
      this.calle = calle;
   }

   public String getAltura() {
      return altura;
   }

   public void setAltura(String altura) {
      this.altura = altura;
   }

   public boolean equals(Ubicacion that){
      return this.pais.equals(that.pais)
              && this.provincia.equals(that.provincia)
              && this.localidad.equals(that.localidad)
              && this.municipio.equals(that.municipio)
              && this.calle.equals(that.calle)
              && this.altura.equals(that.altura);
   }

}
