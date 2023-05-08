from selenium import webdriver
from bs4 import BeautifulSoup
import pandas as pd
driver = webdriver.Chrome("/usr/lib/chromium-browser/chromedriver")
products=[] #List to store name of the product
prices=[] #List to store price of the product
url='https://www.epa.com.br/mg/ofertas-epa/'
driver.get(url)
content = driver.page_source
with open("epa.txt",'w', encoding="utf-8") as f:
    f.write(content)
soup = BeautifulSoup(content)
for a in soup.findAll('class',href=True, attrs={'class':'product-name'}):
    name=a.find('class', attrs={'class':'product-name'})
    preco=a.find('class', attrs={'class':'product-price'})
    preco+='.'
    preco+=a.find('div', attrs={'class':'vtex-product-price-1-x-currencyFraction vtex-product-price-1-x-currencyFraction--sellingPriceUnit'})
    products.append(name.text)
    prices.append(preco.text)
    print(preco)
    print(name)
df = pd.DataFrame({'Product Name':products,'Price':prices}) 
df.to_csv('epaListaProduto.csv', index=False, encoding='utf-8')
