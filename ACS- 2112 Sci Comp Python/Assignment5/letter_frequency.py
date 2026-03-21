def most_frequent(sample:str, return_table:bool):
    """"
    Calculates the frequency of each character in a sample sequence.
    and returns sorted list of tuples (frequency, character) if return_table is True.
    """
    d = {}
    t = []
    for s in sample:
        if s.isalpha():
            d[s] = 1 + d.get(s, 0)

    if return_table:
        return sorted(zip(d.values(), d.keys()), reverse=True)

most_frequent("A paragraph is a series of sentences that are organized and coherent, and are all related to a"
                    "single topic. Almost every piece of writing you do that is longer than a few sentences should be organized into"
                    "paragraphs. This is because paragraphs show a reader where the subdivisions of an essay begin and"
                    "end, and thus help the reader see the organization of the essay and grasp its main points."
                    #https://wts.indiana.edu/writing-guides/paragraphs-and-topic-sentences.html#:~:text=A%20paragraph%20is%20a%20series,should%20be%20organized%20into%20paragraphs.
                    , True)
most_frequent("Bonjour, camarades de classe. Je m'appelle [MY NAME] et je vais parle de moi. J'ai vingt-deux ans et je" 
                    "travaille dans un restaurant vietnamien. Je me decrirais comme agreable et optimiste. Mes parents sont e"
                    "spagnol et je suis americain. J'adore la musique, mes favoris sont Daft Punk et Metallica. Mon but est de"
                    "visiter la France l'annee prochaine."
                    #Bonjour, camarades de classe. Je m'appelle [MY NAME] et je vais parle de moi. J'ai vingt-deux ans et je travaille dans un restaurant vietnamien. Je me decrirais comme agreable et optimiste. Mes parents sont espagnol et je suis americain. J'adore la musique, mes favoris sont Daft Punk et Metallica. Mon but est de visiter la France l'annee prochaine.)
                    ,True)
#Finding- 'e' is the highest frequency word in both languages.