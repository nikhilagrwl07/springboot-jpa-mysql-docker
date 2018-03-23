For test profile - 
-Dspring.profiles.active=test

For prod profile -
-Dspring.profiles.active=prod

For normal profile -
nothing to pass
-----------------------------------------------------

TO DO List -
1. Fix Controller Test Case
2. Fix Docker Compose
3. Learn Spring security


#while ! exec 6<>/dev/tcp/${DATABASE_HOST}/${DATABASE_PORT}; do
#    echo "Trying to connect to MySQL at ${DATABASE_PORT}..."
#    sleep 10
#done
