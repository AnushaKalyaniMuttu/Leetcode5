SELECT c.candidate_id
FROM Candidates AS c
JOIN Rounds AS r
  ON c.interview_id = r.interview_id
WHERE c.years_of_exp >= 2
GROUP BY c.candidate_id
HAVING SUM(r.score) > 15;



/*
You are given two database tables:

Table 1: Candidates
Column	Type	Description
candidate_id	int	Unique ID of a candidate
name	varchar	Candidate’s name
years_of_exp	int	Years of work experience
interview_id	int	ID linking to interview rounds
Table 2: Rounds
Column	Type	Description
interview_id	int	Interview identifier (links to Candidates)
round_id	int	Which round of interview
score	int	Score in that round

Your task: Find all candidates who:

Have at least 2 years of experience, and
Their total interview score is strictly greater than 15

Return the list of selected candidate_id values in any order.

🧠 Example

Input Tables:

Candidates

candidate_id	name	years_of_exp	interview_id
11	Atticus	1	101
9	Ruben	6	104
6	Aliza	10	109
8	Alfredo	0	107

Rounds

interview_id	round_id	score
109	3	4
101	2	8
109	4	1
107	1	3
104	3	6
109	1	4
104	4	7
104	1	2
109	2	1
104	2	7
107	2	3
101	1	8

Output:

candidate_id
9
*/
