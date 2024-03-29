--MS SQL SERVER

SELECT sub.hacker_id, (SELECT name 
		       FROM hackers
		       WHERE sub.hacker_id = hacker_id
		      )
FROM difficulty AS dif 
INNER JOIN challenges AS cha ON cha.difficulty_level = dif.difficulty_level
INNER JOIN submissions AS sub ON sub.challenge_id = cha.challenge_id and sub.score = dif.score
GROUP BY sub.hacker_id
HAVING COUNT(sub.hacker_id) > 1
ORDER BY COUNT(sub.hacker_id) DESC, hacker_id
