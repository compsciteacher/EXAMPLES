'''
I added most of the comments, my students are poor at doing that :(
I also commented some stuff out/changed file names so school name and stuff
wouldn't be shown.'''

#importing csv, time, os and the GPIO are the most necessary
import getpass
import csv
import time
import os
import re
import RPi.GPIO as io 
from datetime import datetime

io.setmode(io.BCM) 
pir_pin = 24 #control pin
power_pin = 27 #power pin
os.system("clear") #clear the screen after every login attempt and at the beginning
io.setup(pir_pin, io.IN) 
io.setup(power_pin, io.OUT)
io.output(power_pin, False)

PERIOD_OF_TIME = 1800 #amount of time for power to stay on
def loginoffline():
    f2 = open('users_pws.csv', 'r')#list of users and passwords. We assign passwords to students so I have them all in csv
    f = open("Logins.txt","a")#opens login file to write user/time 
    students=csv.reader(f2)
    username=input("Please enter your username: ")
    password=getpass.getpass("Please enter your password: ")
    username_rowgetnumyo=2 #change host_row to the corresponding row - 1 (ie; row 45, put in 44) in google's csv
    password_rowgetnum=3 #master_row to the schools student list
    for hosts_rowyo in students:
        row = 1
        username=username.replace("@schoolname.com","")#student emails are 4 digits@schoolname.com, for some reason the students wanted to just get rid of school name? I just let it be
        hosts_rowyo[username_rowgetnumyo]=hosts_rowyo[username_rowgetnumyo].replace("@schoolname.com","")
        hosts_rowyo[username_rowgetnumyo]=hosts_rowyo[username_rowgetnumyo].zfill(4)
        if (username == hosts_rowyo[username_rowgetnumyo]) & (password == hosts_rowyo[password_rowgetnum]):
            print("Logging in.", end=""),
            time.sleep(1)
            print(".", end=""),
            time.sleep(1)
            print(".")
            time.sleep(3)
            os.system("clear")
            print("Logging in complete! Plug in your chromebook now;")
            f.write(username+" "+str(datetime.now())+"\n")
            f.close()#this line was actually important. The students weren't closing the doc, and the appending was getting all messed up. Took them time to problem solve this actually
            start = time.time()
            while True :#powers on the powerswitch
                io.output(power_pin, True)
                
                if time.time() > start + PERIOD_OF_TIME:
                    print("POWER OFF")
                    time.sleep(1)
                    io.output(power_pin, False)
                    time.sleep(3)
                    loginoffline()
                    break
            break
    print("Logging in.", end=""),
    time.sleep(1)
    print(".", end=""),
    time.sleep(1)
    print(".")
    time.sleep(3)
    os.system("clear")
    print("Error logging in, please try again! ")
    loginoffline()
    f2.close()
    f.close()
    
loginoffline()
