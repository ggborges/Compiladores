# PROBLEMA 5.

import pandas as pd
import pyodbc

# Configurações do bancod de dados
DB_SERVER = 'DESKTOP-KG0JK9D'
DB_NAME = 'TESTE'
DB_USER = 'guga_borges'
DB_PASSWORD = 'kaYa.245608'
DRIVER = 'ODBC Driver 18 for SQL Server'

# Leitura do arquivo CSV
arquivo_csv = 'produtos.csv'

df = pd.read_csv(arquivo_csv)

print(df)
print(f"Data types: ", df.dtypes.to_dict())

# Identificando os tipos de dados do data_frame

type_mapping = {
    'object': 'VARCHAR(100)',
    'int64': 'BIGINT',
    'float64': 'FLOAT',
    'datetime[ns]': 'DATETIME',
    'bool': 'BIT'
}

df_columns = df.columns.tolist()
df_columns2 = [col.replace(" ", "_") for col in df_columns]
df.columns = df_columns2
data_types = df.dtypes.to_dict()
print(f'data_types>>>> {data_types}')
print(f"dfcolumns>>> {df.columns}")

columns_types = ", ".join(f"{col} {type_mapping[str(data_types[col])]}" for col in df.columns)

print(columns_types)
# Conexão com banco de dados usando pyodbc
#connection_str = f'DRIVER={DRIVER};SERVER={DB_SERVER};DATABASE={DB_NAME};UID={DB_USER};PWD={DB_PASSWORD};Encrypt=no'
connection_str = f'DRIVER={DRIVER};SERVER={DB_SERVER};DATABASE={DB_NAME};TRUSTED_CONNECTION=yes;Encrypt=no'
connection = pyodbc.connect(connection_str)

# Executando consulta
cursor = connection.cursor()
cursor.execute(f'CREATE TABLE stg_prontuario.TABELA_CSV ({columns_types});')
print(", ".join(df.columns))

values_list = [tuple(row) for row in df.values]
insert_str = f'INSERT INTO stg_prontuario.TABELA_CSV ({", ".join(df.columns)}) VALUES ({", ".join(["?"] * len(df.columns))})'
cursor.executemany(insert_str, values_list)

#rows = cursor.fetchall()
#
#for row in rows:
#    print(row)

connection.close()