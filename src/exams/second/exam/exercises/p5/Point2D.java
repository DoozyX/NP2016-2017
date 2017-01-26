package exams.second.exam.exercises.p5;

class Point2D implements Distance<Point2D>{
	private long id;
	private float x;
	private float y;

	public Point2D(long id, float x, float y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}

	public double calculateDistance(Point2D point) {
		return Math.sqrt(Math.pow((x - point.x), 2) + Math.pow((point.y - y), 2));
	}

	@Override
	public long getId() {
		return id;
	}
}
