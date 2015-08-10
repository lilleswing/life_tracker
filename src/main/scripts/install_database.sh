#!/bin/bash
psql -p 3247 -c "DROP DATABASE IF EXISTS life_tracker"
psql -p 3247 -c "CREATE DATABASE life_tracker"
psql -d life_tracker -p 3247 -a -f src/main/resources/schema.sql

