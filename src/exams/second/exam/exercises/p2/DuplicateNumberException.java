package exams.second.exam.exercises.p2;

class DuplicateNumberException extends Exception{
	public DuplicateNumberException(String message) {
		super("Duplicate number: " + message);
	}
}
