SELECT sub.hacker_id, (SELECT name FROM hackers WHERE sub.hacker_id = hacker_id)
FROM difficulty as dif 
INNER JOIN challenges as cha ON cha.difficulty_level = dif.difficulty_level
INNER JOIN submissions as sub ON sub.challenge_id = cha.challenge_id and sub.score = dif.score
GROUP BY sub.hacker_id
HAVING count(sub.hacker_id) > 1
ORDER BY count(sub.hacker_id) DESC, hacker_id
