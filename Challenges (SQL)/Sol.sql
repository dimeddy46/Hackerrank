// MS SQL SERVER

DECLARE @mx INT = (SELECT TOP 1 COUNT(challenge_id) 
                   FROM challenges
                   GROUP BY hacker_id
                   ORDER BY COUNT(challenge_id) DESC
                  )
                   
DECLARE @withoutDups TABLE(cont INT PRIMARY KEY);
INSERT INTO @withoutDups
SELECT cts
FROM (
    SELECT COUNT(challenge_id) AS cts
    FROM challenges
    GROUP BY hacker_id
) AS withDups
GROUP BY cts
HAVING COUNT(cts) = 1;

SELECT h.hacker_id,name, COUNT(challenge_id)
FROM hackers AS h
INNER JOIN challenges AS c ON h.hacker_id = c.hacker_id
GROUP BY h.hacker_id, name
HAVING COUNT(challenge_id) = @mx OR 
       EXISTS(SELECT cont 
               FROM @withoutDups 
               WHERE cont = COUNT(challenge_id)
              )
ORDER BY COUNT(challenge_id) DESC, h.hacker_id;