from django.shortcuts import render

# Create your views here.
from django.http import JsonResponse
import os
from datetime import datetime
import random


def MyView(request):
    return render(request,'main.html',{'selector':"value"})
def MyJson(request):
    
    cwd = os.getcwd()
    with open(cwd+'/pizza_json/src/pizza_name') as f:

        pizzas = f.readlines()

    
    resa = []
    for  i in pizzas:
        name,link = i.split('@')
        tmp = {'pizza_name':name,'link_photo':link.strip(), 'price':random.randint(80,130),'diameter':22,'mass':random.choice([280,300,350,200,250,270])}
        resa.append(tmp)

   

            


    resault={'Pizzas':resa}
    return JsonResponse(resault)
