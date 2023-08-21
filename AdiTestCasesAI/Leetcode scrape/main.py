from leetscrape.GetQuestionsList import GetQuestionsList
from leetscrape.GetQuestionInfo import GetQuestionInfo
from leetscrape.utils import combine_list_and_info, get_all_questions_body
import pandas as pd

ls = GetQuestionsList()
ls.scrape() 
ls.to_csv(directory_path="../Leetcode scrape/") 

questions_info = pd.read_csv("../Leetcode scrape/questions.csv")

questions_body_list = get_all_questions_body(
    questions_info["titleSlug"].tolist(),
    questions_info["paidOnly"].tolist(),
    save_to="../Leetcode scrape/questionBody.pickle",
)

questions_body = pd.DataFrame(
    questions_body_list
).drop(columns=["titleSlug"])
questions_body["QID"] = questions_body["QID"].astype(int)

questions = combine_list_and_info(
    info_df = questions_body, list_df=ls.questions, save_to="../Leetcode scrape/all.json"
)