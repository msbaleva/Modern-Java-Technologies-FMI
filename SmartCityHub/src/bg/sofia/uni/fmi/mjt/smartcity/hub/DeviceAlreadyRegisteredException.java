package bg.sofia.uni.fmi.mjt.smartcity.hub;

public class DeviceAlreadyRegisteredException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeviceAlreadyRegisteredException(){
		
	}
	
    public DeviceAlreadyRegisteredException(String s){
		super(s);
	}

}
