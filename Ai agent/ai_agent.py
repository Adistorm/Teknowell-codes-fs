# ai_agent.py

import os
from dotenv import load_dotenv
from langchain_openai import ChatOpenAI   # ✅ Correct import for OpenAI
from langchain.agents import Tool, initialize_agent, AgentType
from langchain.memory import ConversationBufferMemory

# --------------------------
# Step 1: Load API Key from .env
# --------------------------
# Create a .env file in the same folder with:
# OPENAI_API_KEY=sk-xxxxxxxxxxxxxxxxxxxxxxxxxxxx
load_dotenv()

# --------------------------
# Step 2: Initialize the LLM
# --------------------------
llm = ChatOpenAI(
    model_name="gpt-4o-mini",   # or "gpt-4" / "gpt-3.5-turbo"
    temperature=0.7
)

# --------------------------
# Step 3: Define Tools
# --------------------------
tools = [
    Tool(
        name="Search",
        func=lambda q: f"Simulated search result for: {q}",
        description="Use this tool to answer questions about current events."
    ),
    Tool(
        name="Calculator",
        func=lambda expr: str(eval(expr)),
        description="Use this tool to calculate math expressions."
    )
]

# --------------------------
# Step 4: Setup Memory
# --------------------------
memory = ConversationBufferMemory(
    memory_key="chat_history",
    return_messages=True   # ✅ Fix for newer LangChain versions
)

# --------------------------
# Step 5: Initialize the Agent
# --------------------------
agent = initialize_agent(
    tools=tools,
    llm=llm,
    agent=AgentType.CHAT_CONVERSATIONAL_REACT_DESCRIPTION,
    memory=memory,
    verbose=True
)

# --------------------------
# Step 6: Interactive Chat
# --------------------------
print("🤖 AI Agent is ready! Type 'exit' to quit.\n")
while True:
    user_input = input("You: ")
    if user_input.lower() in ["exit", "quit"]:
        print("👋 Goodbye!")
        break

    try:
        response = agent.invoke(user_input)   # ✅ Use invoke instead of run
        print(f"Agent: {response}\n")
    except Exception as e:
        print(f"⚠️ Error: {e}\n")
