import psycopg2
import uuid
import random


sql = """INSERT INTO animal(id, name, kingdom) VALUES(%s, %s, %s);"""
num_entries = 10
animals = {
    'Dog': 'Vertebrate',
    'Cat': 'Vertebrate',
    'Worm': 'Invertebrate',
    'Jellyfish': 'Invertebrate'
}

def bulk_insert():
    conn = None
    try:
        conn = psycopg2.connect(
            host='localhost',
            port=5432,
            database="test",
            user="testUser",
            password='password'
        )

        cursor = conn.cursor()

        for i in range(num_entries):
            uid = str(uuid.uuid4())
            animal, kingdom = random.choice(list(animals.items()))
            cursor.execute(sql, (uid, animal, kingdom))
            conn.commit()

        cursor.close()
    except (Exception, psycopg2.DatabaseError) as error:
        print(error)
    finally:
        if conn is not None:
            conn.close()


if __name__ == '__main__':
    bulk_insert()
