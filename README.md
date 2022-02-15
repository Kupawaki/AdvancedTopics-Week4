# AdvancedTopics-Week4
## Major Info (TLDR)

### Goals:
The goals for this week were to create a very simple application that identifies an active internet connection on an event. I also wanted to get some information on the connected network, such as an SSID.

### Problems Encountered

#### Problem 1: Many methods require a min API of 29
##### Status: Solved
Lots of connectionInfo methods, such as getSecurityInfo(), require a min API of 29 to function. This is easily fixable, I just changed my min API to 29, although it is sort of a pain. 

#### Problem 2: Getting an SSID requires Location Permissions
##### Status: Solved
I really dont know why, but getting an SSID from connectionInfo requrires that the app has location permission, which must be manually granted by a user outside of the app.


### App Completion Status
This Proof of Concept has been fully completed  

### Tools and Resources
#### Video Tutorial
https://youtu.be/3FQYp2J_Nnw
#### Stack Overflow
https://stackoverflow.com/questions/21391395/get-ssid-when-wifi-is-connected

## Other Information
I am happy with this POC, as it does exactly what I need it to do, with a plus side that this is the first app I have ever exported to my phone and had it work properly

