
public class BusinessLogic {

	double mass, velocity;

	final double half = 0.5;

	final double speed_of_light = 299792458;

	public double getSpeed_of_light() {
		return speed_of_light;
	}

	public double getHalf() {
		return half;
	}

	public double getMass() {
		return mass;
	}

	public void setMass(double pMass) {
		mass = pMass;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double pVelocity) {
		this.velocity = pVelocity;
	}

	public double gamma() {

		return 1 / Math.sqrt(1 - (Math.pow(getVelocity(), 2) / Math.pow(getSpeed_of_light(), 2)));
	}

	public double momentum() {

		return getMass() * getVelocity();
	}

	public double energy() {

		return getHalf() * getMass() * getVelocity() * getVelocity();
	}

	public double relativistic_momentum() {

		return getMass() * getVelocity() * gamma();
	}

	public double relativistic_energy() {

		return (gamma() - 1) * getMass() * getSpeed_of_light() * getSpeed_of_light();
	}
}
