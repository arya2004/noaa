import pandas as pd

class AIBot:
    def __init__(self, csv_path):
        self.Final10 = pd.read_csv(csv_path)

    def get_problem_statement(self, company, tags):
        filtered_data = self.Final10[
            (self.Final10['Company'].str.lower() == company.lower()) &
            (self.Final10['Tags'].str.lower().str.contains(tags.lower()))
        ]
        
        if not filtered_data.empty:
            problem_statement = filtered_data.iloc[0]['Question']
            test_cases = filtered_data.iloc[0]['Test Cases']
            return problem_statement + '\n\nTest Cases:\n' + test_cases
        else:
            return "I couldn't find a problem statement for that combination."

def main():
    csv_path = 'Final10.csv'  # Update the CSV file path
    ai_bot = AIBot(csv_path)
    
    while True:
        user_input = input("Ask a question or request a problem statement (type 'exit' to quit): ")
        if user_input.lower() == 'exit':
            break
        
        if "give me question asked by" in user_input.lower() and "based on" in user_input.lower():
            parts = user_input.split("give me question asked by")[1].strip().split("based on")
            if len(parts) == 2:
                company = parts[0].strip()
                tags = parts[1].strip()
                problem_statement = ai_bot.get_problem_statement(company, tags)
                print("Problem Statement:\n", problem_statement)
            else:
                print("Invalid format. Please use 'give me question asked by [company] based on [concept]'")

        else:
            print("Invalid input. Please ask a question or request a problem statement.")

if __name__ == "__main__":
    main()
