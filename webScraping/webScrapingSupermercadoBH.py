from selenium import webdriver
from bs4 import BeautifulSoup
import pandas as pd
driver = webdriver.Chrome("/usr/lib/chromium-browser/chromedriver")
products=[] 
prices=[] 
url="www.supermercadosbh.com.br/belo-horizonte/ofertas/"
driver.get(url)
content = driver.page_source
#with open("bh.txt",'w',encoding="utf-8") as f:
#   f.write(content)
soup = BeautifulSoup(content)
for a in soup.findAll('a',href=True, attrs={'class':'card-details-name'}):
    name=a.find('class', attrs={'class':'card-details-name'})
    preco=a.find('class', attrs={'class':'card-details-price'})
    products.append(name.text)
    prices.append(preco.text)
    print(preco)
    print(name)
df = pd.DataFrame({'Product Name':products,'Price':prices}) 
df.to_csv('products.csv', index=False, encoding='utf-8')
