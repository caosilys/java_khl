package day17;

public class ExbScore {
	
	private String subjectTitle;
	private String point;
	private int grade;
	private int term;
	
	public ExbScore(String subjectTitle, String point, int grade, int term) 
	{
		this.subjectTitle = subjectTitle;
		this.point = point;
		this.grade = grade;
		this.term = term;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + grade;
		result = prime * result + ((subjectTitle == null) ? 0 : subjectTitle.hashCode());
		result = prime * result + term;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExbScore other = (ExbScore) obj;
		if (grade != other.grade)
			return false;
		if (subjectTitle == null) {
			if (other.subjectTitle != null)
				return false;
		} else if (!subjectTitle.equals(other.subjectTitle))
			return false;
		if (term != other.term)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExbScore [subjectTitle=" + subjectTitle + ", point=" + point + ", grade=" + grade + ", term=" + term
				+ "]";
	}
	
	
	
}
