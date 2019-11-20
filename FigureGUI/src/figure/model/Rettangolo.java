package figure.model;

public class Rettangolo {
	/** la posizione sullo schermo, in pixel */
	private int x, y;

	private int base, altezza;

	public Rettangolo(int x, int y, int base, int altezza) {
		super();
		this.x = x;
		this.y = y;
		this.base = base;
		this.altezza = altezza;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the base
	 */
	public int getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(int base) {
		this.base = base;
	}

	/**
	 * @return the altezza
	 */
	public int getAltezza() {
		return altezza;
	}

	/**
	 * @param altezza the altezza to set
	 */
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

}
