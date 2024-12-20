package activities;

public class Activity3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int age= 1000000000; double earthYear= 31.69;
		  
		  double MercuryAge; MercuryAge=earthYear/0.2408467;
		  System.out.println("Mercury age is "+MercuryAge);
		  
		  double VenusAge; VenusAge= earthYear/0.61519726;
		  System.out.println("Jupiter age is "+VenusAge);
		  
		  double MarsAge; MarsAge= earthYear/1.8808158;
		  System.out.println("Mars age is "+MarsAge);
		  
		  double JupiterAge; JupiterAge= earthYear/11.862615;
		  System.out.println("Jupiter age is "+JupiterAge);
		  
		  double SaturnAge; SaturnAge= earthYear/29.447498;
		  System.out.println("Saturn age is "+SaturnAge);
		  
		  double UranusAge; UranusAge= earthYear/84.016846;
		  System.out.println("Uranus age is "+UranusAge);
		  
		  double NeptuneAge; NeptuneAge= earthYear/164.79132;
		  System.out.println("Neptune age is "+NeptuneAge);
		  
		  
		  System.out.println("--------------------");
		 
		double seconds = 1000000000;

		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;

		System.out.println("Age on Mercury: " + seconds / EarthSeconds / MercurySeconds);
		System.out.println("Age on Venus: " + seconds / EarthSeconds / VenusSeconds);
		System.out.println("Age on Earth: " + seconds / EarthSeconds);
		System.out.println("Age on Mars: " + seconds / EarthSeconds / MarsSeconds);
		System.out.println("Age on Jupiter: " + seconds / EarthSeconds / JupiterSeconds);
		System.out.println("Age on Saturn: " + seconds / EarthSeconds / SaturnSeconds);
		System.out.println("Age on Uranus: " + seconds / EarthSeconds / UranusSeconds);
		System.out.println("Age on Neptune: " + seconds / EarthSeconds / NeptuneSeconds);

	}

}
