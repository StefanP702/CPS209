/**
   A student has a name, total quiz score and number of quizzes
*/
public class Student
{  
    private String name ; // the name of the student
    private int countQuizzes ; // number of quizzes
    private double totalQuizScore ; // total score for the student
    /**
       Constructor method: initialize name with given name1,
	   set other instance variables to 0
       @param name1 the name of the student
    */
    public Student(String name1)
    {   
	//$start Complete this constructor
	name = name1 ;
	//$end
	countQuizzes = 0 ;
	totalQuizScore = 0.0 ;
    }
    
    /**
       Gets the average quiz score
       @return the average of all quizzes
    */
    public double getAverageScore()
    {  
	//$start Complete this method
	return totalQuizScore / countQuizzes ;
	//$end
    }
    
    /**
       Adds on another quiz
       @param score the score the student had on the quiz
    */
    public void addQuiz(double score)
    {   
	//$start Complete this method
	totalQuizScore = totalQuizScore + score;
	countQuizzes++ ;
	//$end
    }
    
    /**
       Gets the current totalQuizScore level of the student.
       @return the current totalQuizScore 
    */
    public double getTotalScore()
    {   
	//$start Complete this method
	return totalQuizScore ;
	//$end
    }
    /**
       Gets the name of the student
       @return the name
    */
    public String getName() 
    {   
	//$start Complete this method
	return name ;
	//$end
    }
}



