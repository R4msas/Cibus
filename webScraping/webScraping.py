from selenium import webdriver
from bs4 import BeautifulSoup
import pandas as pd
driver = webdriver.Chrome("/usr/lib/chromium-browser/chromedriver")
products=[] #List to store name of the product
prices=[] #List to store price of the product
url="https://www.supernosso.com/promocoes"
driver.get(url)
content = driver.page_source
with open("site.txt",'w',encoding="utf-8") as f:
    f.write(content)
soup = BeautifulSoup(content)
for a in soup.findAll('span',href=True, attrs={'class':'"vtex-flex-layout-0-x-flexRow'}):
    name=a.find('span', attrs={'class':'vtex-store-components-3-x-productBrand'})
    preco=a.find('span', attrs={'class':'vtex-product-price-1-x-currencyInteger vtex-product-price-1-x-currencyInteger--sellingPriceUnit'})
    preco+='.'
    preco+=a.find('div', attrs={'class':'vtex-product-price-1-x-currencyFraction vtex-product-price-1-x-currencyFraction--sellingPriceUnit'})
    products.append(name.text)
    prices.append(preco.text)
    print(preco)
    print(name)
df = pd.DataFrame({'Product Name':products,'Price':prices}) 
df.to_csv('products.csv', index=False, encoding='utf-8')


